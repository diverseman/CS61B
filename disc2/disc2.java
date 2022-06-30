class Cat {
          public String name;
          public static String noise;
 
          public Cat(String name, String noise) {
          this.name = name;
          this.noise = noise;
          }
 
           public void play() {
           System.out.println(noise + " I'm " + name + " the cat!");
           }
  
           public static void anger() {
           noise = noise.toUpperCase();
           }
           public static void calm() {
           noise = noise.toLowerCase();
           }

public static void main(String[] args) {
              /*
              noise 为静态变量，所有对象共用一份
               */
          Cat a = new Cat("Cream", "Meow!");
          Cat b = new Cat("Tubbs", "Nyan!");
          a.play();
          b.play();
          Cat.anger();
          a.calm();
          a.play();
          b.play();
          }
   }
class Pokemon {
 public String name;
 public int level;

         public Pokemon(String name, int level) {
         this.name = name;
         this.level = level;
         }

         public static void main(String[] args) {
         Pokemon p = new Pokemon("Pikachu",17 );
         int level = 100;
         change(p, level);
         System.out.println("Name: " + p.name + ", Level: " + p.level);
         }

         public static void change(Pokemon poke, int level) {
         poke.level = level;
         level = 50;
         poke = new Pokemon("Gengar", 1);
         }
 }
   