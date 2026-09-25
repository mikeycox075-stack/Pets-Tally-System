class Cat extends Pets{
    private String breed;
    public Cat(String name,int age,String breed){
        super(name,age);
        this.breed = breed;
    }
    public void SetBreed(String breed){
        this.breed = breed;
    }
    @Override
    public String toString() {
        return super.toString() + "Cat";
    }
    public String Speak() {
        return super.toString() + "," + "Meow" + " my breed is " +  breed;
    }
}