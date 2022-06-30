### 1.(this is the final version for disc2)
```java
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
```
**note；注意这里面p 和 poke 是两个事实存在的对象，调用函数时参数传递不到p**


(1)Name:Pikachu, Level:100

(2)
p--->Pikachu
     100
then:
poke--->Gengar
        1
     1

(3) the local variable containing the parameter to the change method

### 2. 
**note: 注意static 是一个类对象的公共变量** 


a ---> Cream Meow

b ---> Tubbs Nyan

Nyan i am Cream the cat!

Nyan! i am Tubbs the cat!

nyan! i am Cream the cat!

nyan! i am Tubbs the cat!

### 3.
(1)
java 可视化

![img.png](img.png)
