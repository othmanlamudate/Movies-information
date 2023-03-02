package users.profile.kotlinapi.Model;

public class Show {
    private String name,country,rating,genere,link,image;
    public Show(String name, String country, String rating, String genere, String link, String image) {
        this.name = name;
        this.country = country;
        this.rating = rating;
        this.genere = genere;
        this.link = link;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Show{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rating='" + rating + '\'' +
                ", genere='" + genere + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
