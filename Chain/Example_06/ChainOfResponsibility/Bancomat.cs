using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace Example_06.ChainOfResponsibility
{
    public enum CurrencyType
    {
        Eur,
        Dollar,
        Ruble
    }

    public class Banknote
    {
        CurrencyType Currency { get; }
        uint Value { get; }

        public Banknote(CurrencyType c, uint v)
        {
            Currency = c;
            Value = v;
        }
    }

    public class Bancomat
    {
        private readonly BanknoteHandler _handler;

        public Bancomat()
        {
            _handler = new TenRubleHandler(null);
            _handler = new TenDollarHandler(_handler);
            _handler = new FiftyDollarHandler(_handler);
            _handler = new HundredDollarHandler(_handler);
        }

        public bool Validate(string banknote)
        {
            return _handler.Validate(banknote);
        }

        public Banknote[] CashOut(CurrencyType c, uint v)
        {
            var result = _handler.CashOut(c, ref v);

            if (v > 0)
            {
                throw new Exception("Введена невалидная сумма");
            }

            return result;
        }
    }

    public abstract class BanknoteHandler
    {
        public virtual Banknote[] CashOut(CurrencyType c, ref uint v)
        {
            if (_nextHandler != null)
            {
                return _nextHandler.CashOut(c, ref v);
            }
            return null;
        }

        private readonly BanknoteHandler _nextHandler;

        protected BanknoteHandler(BanknoteHandler nextHandler)
        {
            _nextHandler = nextHandler;
        }

        public virtual bool Validate(string banknote)
        {
            return _nextHandler != null && _nextHandler.Validate(banknote);
        }
    }

    public class TenRubleHandler : BanknoteHandler
    {
        public override bool Validate(string banknote)
        {
            if (banknote.Equals("10 Рублей"))
            {
                return true;
            }
            return base.Validate(banknote);
        }

        public TenRubleHandler(BanknoteHandler nextHandler) : base(nextHandler) { }

        public override Banknote[] CashOut(CurrencyType c, ref uint v)
        {
            if (c == CurrencyType.Ruble)
            {
                if (v / 10 > 0)
                {
                    var count = v / 10;
                    var list = new Banknote[count];

                    for (int i = 0; i < count; i++)
                    {
                        var bancnote = new Banknote(c, 10);

                        list[i] = bancnote;
                    }
                    v -= count * 10;
                    return list.Concat(base.CashOut(c, ref v)).ToArray();
                }

                return base.CashOut(c, ref v);
            }
            return base.CashOut(c, ref v);
        }
    }

    public abstract class DollarHandlerBase : BanknoteHandler
    {
        public override bool Validate(string banknote)
        {
            if (banknote.Equals($"{Value}$"))
            {
                return true;
            }
            return base.Validate(banknote);
        }

        protected abstract uint Value { get; }

        protected DollarHandlerBase(BanknoteHandler nextHandler) : base(nextHandler)
        { }

        public override Banknote[] CashOut(CurrencyType c, ref uint v)
        {
            if (c == CurrencyType.Dollar)
            {
                if (v / Value > 0)
                {
                    var count = v / Value;
                    var list = new Banknote[count];

                    for (int i = 0; i < count; i++)
                    {
                        var bancnote = new Banknote(c, Value);

                        list[i] = bancnote;
                    }
                    v -= count * Value;
                    return list.Concat(base.CashOut(c, ref v)).ToArray();
                }

                return base.CashOut(c, ref v);
            }
            return base.CashOut(c, ref v);
        }
    }

    public class HundredDollarHandler : DollarHandlerBase
    {
        protected override uint Value => 100;

        public HundredDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }

    }

    public class FiftyDollarHandler : DollarHandlerBase
    {
        protected override uint Value => 50;

        public FiftyDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }
    }

    public class TenDollarHandler : DollarHandlerBase
    {
        protected override uint Value => 10;

        public TenDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }
    }
}