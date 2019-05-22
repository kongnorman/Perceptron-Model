public class SingleLayerNN {

	public static void main(String args[]) {

		double[][] trainset = {{0, 0, 1, 0},
							{1, 1, 1, 0}, 
							{1, 0, 1, 1}, 
							{0, 1, 1, 1}, 
							{0, 1, 0, 1},
							{1, 1, 1, 1}, 
							{0, 0, 0, 0}};

		double[] trainlabels = {0, 1, 1, 0, 0, 1, 0};

		double[][] testset = { {0, 1, 1, 0},
							{0, 0, 0, 1},
							{0, 1, 0, 0},
							{1, 0, 0, 1},
							{1, 0, 0, 0},
							{1, 1, 0, 0},
							{1, 0, 1, 0} };

		double learningr = 10;
		int its = 1000;

		// Create perceptron object
		Perceptron neuron = new Perceptron(trainset[0]);

		// Print initial weights
		System.out.println("weights initial");
		for (double weight : neuron.getWeights()) {
			System.out.println(weight);
		}

		// Training over all training sets (1)
		for (int i=0; i<trainset.length; i++) {
			neuron.setInput(trainset[i]);
			neuron.train(trainset[i], trainlabels, its, learningr, i);
		}

		// Training over all training sets (2)
		for (int i=0; i<trainset.length; i++) {
			neuron.setInput(trainset[i]);
			neuron.train(trainset[i], trainlabels, its, learningr, i);
		}

		// Training over all training sets (3)
		for (int i=0; i<trainset.length; i++) {
			neuron.setInput(trainset[i]);
			neuron.train(trainset[i], trainlabels, its, learningr, i);
		}

		System.out.println("weights final");
		for (double weight : neuron.getWeights()) {
			System.out.println(weight);
		}

		// Test results
		System.out.println();
		System.out.println("results: ");

		for (double[] set : testset) {
			neuron.setInput(set);
			System.out.println(neuron.getPrediction());
		}

	} // End main

} // End class