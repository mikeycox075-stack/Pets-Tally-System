class Dog extends Pets{
    private String breed;
    public Dog(String name,int age,String breed){
        super(name,age);
        this.breed = breed;
    }
    public void SetBreed(String breed){
        this.breed = breed;
    }
    @Override
    public String toString() {
        return super.toString() + "Dog";
    }
    public String Speak() {
            return super.toString() + "," + "Bark" + " my breed is " +  breed;
    }
}
