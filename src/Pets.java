public class Pets {
        private String name;
        private int age;

    public Pets(String name, int age){
        this.name = name;
        this.age = age;
    }//end of animal
    public String GetName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void SetAge(int age){
        this.age = age;
    }
    public void SetName(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "My name is " + name + ". My age is " + age;
    }
    public String Speak() {
        return "I make the sound: ";
    }//end of to string
}//end of class


