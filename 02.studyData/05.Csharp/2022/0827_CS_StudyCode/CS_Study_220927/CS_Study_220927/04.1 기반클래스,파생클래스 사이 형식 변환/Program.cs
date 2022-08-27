
//namespace main6;
//class Program
//{
//    public static void Main(string[] args)
//    {
//        //기본적 코드
//        Mammal mammal = new Mammal();
//        mammal.Nurse();

//        Dog dog = new Dog();
//        dog.Nurse();   
//        dog.Bark();

//        Cat cat = new Cat();    
//        cat.Nurse();
//        cat.Meow();

//        //좀더 개선된 코드
//        Mammal mammal1 = new Mammal();
//        mammal1.Nurse();

//        mammal1 = new Dog();
//        mammal1.Nurse();

//        Dog dog1 = (Dog)mammal1;
//        dog1.Nurse();
//        dog1.Bark();

//        mammal1 = new Cat();
//        mammal1.Nurse();

//        Cat cat1 = (Cat)mammal1;
//        cat1.Nurse();
//        cat1.Meow();

//        // is, as 연산자
//        Mammal mammal2 = new Dog();
//        Dog dog2;
//        if (mammal2 is Dog)
//        {
//            dog2 = (Dog) mammal2;
//            dog2.Bark();
//        }

//        Mammal mammal3 = new Cat();
//        Cat cat2 = mammal3 as Cat;
//        if(cat2 != null)
//        {
//            cat2.Meow();
//        }

//    }
//}
