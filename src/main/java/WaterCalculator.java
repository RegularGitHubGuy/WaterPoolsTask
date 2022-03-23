public class WaterCalculator {

    private final LandscapeValidator landscapeValidator = new LandscapeValidator();

    public long calculateWaterAmount(int[] landscape) {

        landscapeValidator.validateLandscape(landscape);

        long result = 0;

        int leftIdx = 0, rightIdx = landscape.length - 1;

        int leftMax = 0, rightMax = 0;

        while (leftIdx < rightIdx) {
            leftMax = Math.max(leftMax, landscape[leftIdx]);
            rightMax = Math.max(rightMax, landscape[rightIdx]);

            if (leftMax < rightMax) {

                result += leftMax - landscape[leftIdx++];
            } else {

                result += rightMax - landscape[rightIdx--];
            }
        }

        return result;
    }

    private static class LandscapeValidator {

        private static final long MAX_WIDTH = 32000;
        private static final long MAX_HEIGHT = 32000;

        public void validateLandscape(int[] landscape) {

            if (landscape.length > MAX_WIDTH) {
                throw new IllegalArgumentException(String.format("Landscape width must be in range [0, %d], %d given.", MAX_WIDTH, landscape.length));
            }

            for (int j : landscape) {
                if (j > MAX_HEIGHT || 0 > j) {
                    throw new IllegalArgumentException(String.format("Landscape high must be in range [0, %d], %d given.", MAX_HEIGHT, j));
                }
            }
        }
    }
}
