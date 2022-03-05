// Don't place your source in a package

// Please name your class Main
class Main {
	public static void main (String[] args) throws java.lang.Exception {
		int[] numbers = {1,2,3,4};
        Template2 template1 = new Template2(numbers);
        int result1 = template1.Result(new Operator() {

            @Override
            public int getResult(int result, int number) {
                if(result ==0) result =1;
                return result*=number;
            }
        });
        Template2 template2 = new Template2(numbers);
       int result2 = template2.Result((result,number)->result+=number);

       System.out.println(result1);
       System.out.println(result2);
	}
}