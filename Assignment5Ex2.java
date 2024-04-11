package Assignment5SW;

import java.util.*;

class Data {
    private String type;
    private Object content;

    public Data(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

abstract class DataProcessor {
    public abstract void process(Data data);
}


class TextDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Text Data Processing: " + data.getContent());
    }
}


class AudioDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Audio Data Processing: " + data.getContent());
    }
}

class VideoDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Video Data Processing: " + data.getContent());
    }
}

class DataProcessorCreator {
    private DataProcessor processor;

    public void setProcessor(DataProcessor processor) {
        this.processor = processor;
    }

    public void processData(Data data) {
        processor.process(data);
    }
}

public class Assignment5Ex2 {
    public static void main(String[] args) {

        DataProcessorCreator creator = new DataProcessorCreator();

        Data textData = new Data("Text", "Sample text data");
        Data audioData = new Data("Audio", "Sample audio data");
        Data videoData = new Data("Video", "Sample video data");

        creator.setProcessor(new TextDataProcessor());
        creator.processData(textData);

        creator.setProcessor(new AudioDataProcessor());
        creator.processData(audioData);

        creator.setProcessor(new VideoDataProcessor());
        creator.processData(videoData);
    }
}
