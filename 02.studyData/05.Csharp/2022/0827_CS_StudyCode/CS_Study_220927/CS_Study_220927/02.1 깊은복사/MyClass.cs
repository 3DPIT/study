using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace main3;
    class MyClass
    {
        public int MyField1;
        public int MyField2;

        //객체를 힙에 할당해서 그곳에 자신의 멤버를 일일이 복사해서 넣음
        public MyClass DeepCopy()
        {
            MyClass newCopy = new MyClass();
            newCopy.MyField1 = MyField1;
            newCopy.MyField2 = MyField2;
            return newCopy;
        }
    }
