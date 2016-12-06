using Example_07.CopyMachine;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Example_07.CopyMachine
{
    enum DeviceType
    {
        WIFI,
        FlashCard
    }

    class Document
    {
        public string Data { get; set; }
    }

    class CopyMachine
    {
        private State state;

        CopyMachine()
        {
            state = new EmptyState();
        }

        public void InsertMoney(uint money)
        {
            state = state.InsertMoney(money);
        }

        public void ChooseDevice(DeviceType dev)
        {
            state = state.ChooseDevice(dev);
        }

        public void SetDocument(Document doc)
        {
            state = state.SetDocument(doc);
        }

        public string PrintDocument()
        {
            string result;

            state = state.Print(out result);
            return result;
        }

        public uint CheckOut()
        {
            uint money;
            state = state.CheckOut(out money);
            return money;
        }
    }

    abstract class State
    {
        internal abstract State CheckOut(out uint money);
        internal abstract State ChooseDevice(DeviceType dev);
        internal abstract State InsertMoney(uint money);
        internal abstract State Print(out string result);
        internal abstract State SetDocument(Document doc);
    }

    class EmptyState : State
    {
        internal override State CheckOut(out uint money)
        {
            throw new Exception();
        }

        internal override State ChooseDevice(DeviceType dev)
        {
            throw new Exception();
        }

        internal override State InsertMoney(uint money)
        {
            return new ChooseDeviceState(money);
        }

        internal override State Print(out string result)
        {
            throw new Exception();
        }

        internal override State SetDocument(Document doc)
        {
            throw new Exception();
        }
    }

    class ChooseDeviceState : State
    {
        private uint money;

        public ChooseDeviceState(uint money)
        {
            this.money = money;
        }

        internal override State CheckOut(out uint money)
        {
            throw new Exception();
        }

        internal override State ChooseDevice(DeviceType dev)
        {
            return new SetDocumentState(money, dev);
        }

        internal override State InsertMoney(uint money)
        {
            throw new Exception();
        }

        internal override State Print(out string result)
        {
            throw new Exception();
        }

        internal override State SetDocument(Document doc)
        {
            throw new Exception();
        }
    }

    internal class SetDocumentState : State
    {
        private DeviceType dev;
        private uint money;

        public SetDocumentState(uint money, DeviceType dev)
        {
            this.money = money;
            this.dev = dev;
        }

        internal override State CheckOut(out uint money)
        {
            money = this.money;
            return new EmptyState();
        }

        internal override State ChooseDevice(DeviceType dev)
        {
            throw new Exception();
        }

        internal override State InsertMoney(uint money)
        {
            throw new Exception();
        }

        internal override State Print(out string result)
        {
            throw new Exception();
        }

        internal override State SetDocument(Document doc)
        {
            return new PrintState(money, dev, doc);
        }
    }

    internal class PrintState : State
    {
        private DeviceType dev;
        private Document doc;
        private uint money;

        public PrintState(uint money, DeviceType dev, Document doc)
        {
            this.money = money;
            this.dev = dev;
            this.doc = doc;
        }

        internal override State CheckOut(out uint money)
        {
            throw new Exception();
        }

        internal override State ChooseDevice(DeviceType dev)
        {
            throw new Exception();
        }

        internal override State InsertMoney(uint money)
        {
            throw new Exception();
        }

        internal override State Print(out string result)
        {
            result = doc.Data;
            money--;
            return new SetDocumentState(money, dev);
        }

        internal override State SetDocument(Document doc)
        {
            throw new Exception();
        }
    }
}
