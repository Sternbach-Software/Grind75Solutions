package easy

class FloodFill {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
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
        if (start != null && start != color) image[sr][sc] = color
        flood(image, sr, sc, start, color)
    }

    private fun flood(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        startingPixel: Int?,
        color: Int
    ) {
        val top = image.getOrNull(sr - 1)?.getOrNull(sc)
        fillAndFlood(top, startingPixel, image, sr - 1, sc, color)
        val bottom = image.getOrNull(sr + 1)?.getOrNull(sc)
        fillAndFlood(bottom, startingPixel, image, sr + 1, sc, color)
        val left = image.getOrNull(sr)?.getOrNull(sc - 1)
        fillAndFlood(left, startingPixel, image, sr, sc - 1, color)
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
            image[x][y] = color
            floodFill(image, x, y, color, startingPixel)
        }
    }
}