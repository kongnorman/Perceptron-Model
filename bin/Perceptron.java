public class Perceptron {

	// Fields.
	double[] input;
	double activation;
	double[] weights = new double[4];

	// Constructor.
	public Perceptron(double[] input) {
		this.input = input;
		for (int i=0; i<weights.length; i++) {
		weights[i] = Math.random();
		}
	} // End constructor.

	// Getter: input.
	public double[] getInput() {
		return input;
	}

	// Getter: weights.
	public double[] getWeights() {
		return weights;
	}

	public void setInput(double[] arr) {
		input = arr;
	} // End setInput() method

	// dot product
	public double z(double[] x, double[] y) {
		double result = 0;
		for (int i=0; i<x.length; i++) {
			result += x[i]*y[i];
		}
		return result;
	} // End z method

	// Sigmoid
	public double sig(double x) {
		double result = 1/(1+Math.exp(-x));
		return result;
	} // End sig method.

	// Sigmoid prime
	public double sigPrime(double x) {
		double result = sig(x) * (1-sig(x));
		return result;
	} // End sigPrime method.

	// Modifier.
	public void train(double[] input, double[] real, int iterations, double lr, int index) {

		double[] gdescent = new double[4];

		// mean
		double[] averages = new double[4];

		averages[0] = 0;
		averages[1] = 0;
		averages[2] = 0;
		averages[3] = 0; 

		for (int i=0; i<iterations; i++) {

			// Feed-forward.
			double z = z(input, weights);
			double prediction = sig(z);

			// Back propogation.
			double cost = Math.pow((prediction - real[index]), 2);

			// Print cost
			if(i % 1000 == 0)
				System.out.println(cost);

			// first feature
			double costPrime = 2*(prediction - real[index]);
			gdescent[0] = input[0] * sigPrime(z(input, weights)) * costPrime;

			// second feature
			gdescent[1] = input[1] * sigPrime(z(input, weights)) * costPrime;

			// third feature
			gdescent[2] = input[2] * sigPrime(z(input, weights)) * costPrime;

			// fourth feature
			gdescent[3] = input[3] * sigPrime(z(input, weights)) * costPrime;

			for (int j=0; j<averages.length; j++) {
				averages[j] += gdescent[j];
			}

		} // End iterations loop

			// final step for averages: divide
			for (int k=0; k<averages.length; k++) {
					averages[k] /= iterations;
				}

			for (int n=0; n<weights.length; n++) {
				weights[n] -= averages[n]*lr;
			}

	} // End train method

} // End class