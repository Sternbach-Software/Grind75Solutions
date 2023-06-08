package easy

class FloodFill {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        println("Provided image: \n${image.joinToString("\n") { it.contentToString() }}")
        floodFill(image, sr, sc, color, image.getOrNull(sr)?.getOrNull(sc))
        return image
    }

    private fun floodFill(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        color: Int,
        start: Int?
    ) {
        println("floodFill(x=$sr,y=$sc,startingPixel(image[$sr][$sc])=$start,color=$color,image=${image.joinToString { it.contentToString() }})")

        if (start != null && start != color) image[sr][sc] = color
        flood(image, sr, sc, start.also { println("Passing starting pixel $start to floodAllExcept") }, color)
    }

    private fun flood(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        startingPixel: Int?,
        color: Int
    ) {
        val top = image.getOrNull(sr - 1)?.getOrNull(sc)
        println("Fill and flood top(${sr - 1},$sc):")
        fillAndFlood(top, startingPixel, image, sr - 1, sc, color)
        val bottom = image.getOrNull(sr + 1)?.getOrNull(sc)
        println("Fill and flood bottom(${sr + 1},$sc):")
        fillAndFlood(bottom, startingPixel, image, sr + 1, sc, color)
        println("Fill and flood left($sr,${sc - 1}):")
        val left = image.getOrNull(sr)?.getOrNull(sc - 1)
        fillAndFlood(left, startingPixel, image, sr, sc - 1, color)
        println("Fill and flood right($sr,${sc + 1}):")
        val right = image.getOrNull(sr)?.getOrNull(sc + 1)
        fillAndFlood(right, startingPixel, image, sr, sc + 1, color)
    }

    private fun fillAndFlood(
        pixel: Int?,
        startingPixel: Int?,
        image: Array<IntArray>,
        x: Int,
        y: Int,
        color: Int
    ) {
        if (pixel != null && pixel == startingPixel && pixel != color) {
            println("fillAndFlood(pixel=$pixel,startingPixel=$startingPixel,x=$x,y=$y,color=$color,image=${image.joinToString { it.contentToString() } }")
            image[x][y] = color
            floodFill(image, x, y, color, startingPixel)
        } else println("Pixel is not equal to starting pixel.($pixel != $startingPixel)")
    }
}