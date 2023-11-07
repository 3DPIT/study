package singleTone6Safe;

public enum Settings{
    INSTANCE;

    Settings(){

    }
    
    private Integer number;

    private Integer getNumber(){
        return number;
    }

    public void setNumber (Integer number){
        this.number = number;
    }
}
