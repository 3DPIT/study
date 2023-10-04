package design.pattern.command.command1;

public class ColorCommand implements  Command{
    public enum Color{
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m");

        final private  String code;
        private Color(String code){
            this.code = code;
        }

        public String getCode(){
            return code;
        }
    };

    private Color color;

    public ColorCommand(Color color) {
        this.color = color;
    }

    @Override
    public void run() {
        System.out.print(color.getCode());
    }
}
