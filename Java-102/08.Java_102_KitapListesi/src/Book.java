public class Book {
    public String name;
    public int pageNum;
    public String writer;
    public int releaseYear;

    public Book(String name, int pageNum, String writer, int releaseYear) {
        this.name = name;
        this.pageNum = pageNum;
        this.writer = writer;
        this.releaseYear = releaseYear;
    }


    public String getName() {
        return name;
    }

    public  int getPageNum() {
        return pageNum;
    }

    public String getWriter() {
        return writer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

}
