package principal;

import java.util.List;

public class LivroGoogle {

    public List<Item> items;

    public static class Item {
        public VolumeInfo volumeInfo;
    }

    public static class VolumeInfo {
        public String title;
        public List<String> authors;
        public String publishedDate;
        public List<String> categories;
        public String pageCount;  
    }
}
