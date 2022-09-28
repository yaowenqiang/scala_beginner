package lectures.partonebasics

object DefaultArgs extends  App {
    def trFact(n: Int, acc: Int = 1) :Int =
        if (n <=1) acc
        else trFact(n-1, n * acc)

   def savePicture(format: String = "JPG", width: Int = 1280, height: Int = 760) : Unit =
       println("saving photos")

    savePicture("JPG", 100, 200)

    savePicture(width = 800, height = 600)
    savePicture( height = 600, width = 800, format = "bitmap")

    var factorial  = trFact(10)
    print(factorial)




}
