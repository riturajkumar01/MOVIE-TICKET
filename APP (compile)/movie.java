// Source code is decompiled from a .class file using FernFlower decompiler.
class Movie {
   String title;
   String genre;
   int duration;

   public Movie(String var1, String var2, int var3) {
      this.title = var1;
      this.genre = var2;
      this.duration = var3;
   }

   public String toString() {
      return this.title + " (" + this.genre + ", " + this.duration + " mins)";
   }
}
