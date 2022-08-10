import org.apache.ibatis.ognl.EnumerationIterator;
import org.junit.Test;

public class test {
    public static void main(String[] args) {
        System.out.println("ssss");

        test test=new test();
        int add = test.add(6, 7);
        System.out.println(add);

        }

     int add(Integer a,Integer b) {
        return a+b;

    }


    @Test
    public void test001(){

        Person person = null;
        person = new Person();
        person.setA(1);
        person.setB(1);
        System.out.println(person);


    }

    class  Person{
        int a;
        int b;

        @Override
        public String toString() {
            return "Person{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        public  Person(){

        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }



}

