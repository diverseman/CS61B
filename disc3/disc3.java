/*1 Static Shock
        Write what the main method will print out once it is executed. It might be helpful
        to draw box and pointer diagrams to keep track of variables*/
/*
对于static变量来说，所有的对象使用的都是同一个static变量，这个变量的数值是可以发生变化，但类型无法发生变化的
 */
class Shock {
 public static int bang;
 public static Shock baby;
 public Shock() {
         this.bang =100;
         }
 public Shock (int num) {
         this.bang = num;//200
         baby = starter();//100
         this.bang += num;//200+100
         }
 public static Shock starter() {
         Shock gear = new Shock();//100
         return gear;
         }
 public static void shrink(Shock statik) {
         statik.bang -= 1;
         }
 public static void main(String[] args) {
         Shock gear = new Shock(200);
         System.out.println(gear.bang); // output:300
         shrink(gear);//299
         shrink(starter());//100
         System.out.println(gear.bang); // output:99
         }
 }

/*2 Horse-o-Scope
        Given the following program, draw out the box and pointer diagram that results
        from executing the inputArray method. What is the output printed by the pro-
        gram? (Summer ’16, MT1)*/
/*
这里还是得清楚instance variable ！！！
 */
 class Horse {
 Horse same;
 String jimmy;

         public Horse(String lee) {
                 jimmy = lee;
                 }

         public Horse same(Horse horse) {
                 if (same != null) {
                         Horse same = horse;
                         same.same = horse;
                         same = horse.same;
                         }
                 return same.same;
                 }

         public static void main(String[] args) {
                 Horse horse = new Horse("youve been");
                 Horse cult = new Horse("horsed");
                 cult.same = cult;
                 cult = cult.same(horse);
                 System.out.println(cult.jimmy);//horsed
                 System.out.println(horse.jimmy);//youve been
                 }

 }
/*3 Give em the ’Ol Switcheroo
        For each function call in the main method, write out the x and y values of both
        foobar and baz after executing that line. (Spring ’15, MT1)*/
/*
需要注意的是：函数Foo a  生成的是一个新的指针，和传入的指针 指向同一个对象
 */

 class Foo {
 public int x, y;

         public Foo (int x, int y) {
                 this.x = x;
                 this.y = y;
                 }

         public static void switcheroo (Foo a, Foo b) {
                 Foo temp = a;
                 a = b;
                 b = temp;
                 }

         public static void fliperoo (Foo a, Foo b) {
                 Foo temp = new Foo(a.x, a.y);
                 a.x = b.x;
                 a.y = b.y;
                 b.x = temp.x;
                 b.y = temp.y;
                 }

         public static void swaperoo (Foo a, Foo b) {
                 Foo temp = a;
                 a.x = b.x;
                 a.y = b.y;
                 b.x = temp.x;
                 b.y = temp.y;
                 }

         public static void main (String[] args) {
                 Foo foobar = new Foo(10,20 );
                 Foo baz = new Foo(30, 40);
                 switcheroo(foobar, baz);
                 System.out.println(foobar.y);
                 System.out.println(baz.x);
                 System.out.println(baz.y);//foobar.y: 20 baz.x: 30 baz.y: 40
                 fliperoo(foobar, baz);
                 System.out.println(foobar.y);
                 System.out.println(baz.x);
                 System.out.println(baz.y);//foobar.y: 40 baz.x: 10 baz.y: 20
                 swaperoo(foobar, baz);
                 System.out.println(foobar.y);
                 System.out.println(baz.x);
                 System.out.println(baz.y);//foobar.y: 20 baz.x: 10 baz.y: 20
                 }
 }

