// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.ArrayList;
import java.util.List;

class Theater {
   String name;
   int royalSeats = 20;
   int premiumSeats = 60;
   int executiveSeats = 20;
   List<Movie> movieList = new ArrayList();

   public Theater(String var1) {
      this.name = var1;
   }

   public void addMovie(Movie var1) {
      this.movieList.add(var1);
   }

   public void showMovies() {
      System.out.println("Movies in " + this.name + ":");

      for(int var1 = 0; var1 < this.movieList.size(); ++var1) {
         System.out.println(var1 + 1 + ". " + String.valueOf(this.movieList.get(var1)));
      }

   }

   public boolean bookSeats(String var1, int var2) {
      switch (var1) {
         case "Royal":
            if (this.royalSeats >= var2) {
               this.royalSeats -= var2;
               return true;
            }
            break;
         case "Premium":
            if (this.premiumSeats >= var2) {
               this.premiumSeats -= var2;
               return true;
            }
            break;
         case "Executive":
            if (this.executiveSeats >= var2) {
               this.executiveSeats -= var2;
               return true;
            }
      }

      return false;
   }
}
