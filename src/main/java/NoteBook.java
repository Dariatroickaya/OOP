public class NoteBook extends Product {
    String ModelLaptop;
    String ScreenResolution;
    String Processor;
    int RAM;
    String VideoCard;

    public NoteBook(
        String Id,
        String Name,
        String Description,
        Float Price,
        String ModelLaptop,
        String ScreenResolution,
        String Processor,
        int RAM,
        String VideoCard
    ) {
        super(Id, Name, Description, Price);
        this.ModelLaptop = ModelLaptop;
        this.ScreenResolution = ScreenResolution;
        this.Processor = Processor;
        this.RAM = RAM;
        this.VideoCard = VideoCard;
    }

    public String getModel() {
        return this.ModelLaptop;
    }
    public String getScreenResolution() {
        return this.ScreenResolution;
    }
    public String getProcessor() {
        return this.Processor;
    }
    public int getRAM(){
        return this.RAM;
    }
    public String getVideoCard(){
        return this.VideoCard;
    }
}
