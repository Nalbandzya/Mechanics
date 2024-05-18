public class Autoassociator {
	private int[][] weights;
	private int size;

	public Autoassociator() {}

	public void train(int[][] data) {
		size = data[0].length;
		weights = new int[size][size];
		for (int[] pattern : data) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i != j) {
						weights[i][j] += pattern[i] * pattern[j];
					}
				}
			}
		}
	}

	public int[] recall(int[] pattern) {
		int[] result = pattern.clone();
		for (int i = 0; i < size; i++) {
			int sum = 0;
			for (int j = 0; j < size; j++) {
				sum += weights[i][j] * pattern[j];
			}
			result[i] = sum >= 0 ? 1 : -1;
		}
		return result;
	}
}
