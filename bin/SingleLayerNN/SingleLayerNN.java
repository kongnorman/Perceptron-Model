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

		double[][] testset = {{0, 1, 1, 0},
							{0, 0, 0, 1},
							{0, 1, 0, 0},
							{1, 0, 0, 1},
							{1, 0, 0, 0},
							{1, 1, 0, 0},
							{1, 0, 1, 0} };

		// Hyperparameters
		double learningr = 0.5;
		int iterations = 100;

		// Create perceptron object
		Perceptron neuron = new Perceptron(trainset[0]);

		// Print initial weights
		System.out.println("weights initial");
		for (double weight : neuron.getWeights()) {
			System.out.println(weight);
		}

		// Training the perceptron over 3 epochs

		// Epoch #1, iterates over all points in training set
		for (int i=0; i<trainset.length; i++) {
			// Sets one point from training data as input
			neuron.setInput(trainset[i]);
			// Trains the perceptron with that one point over num_of_epochs
			neuron.train(trainset[i], trainlabels, iterations, learningr, i);
		}

		// Epoch #2, iterates over all points in training set
		for (int i=0; i<trainset.length; i++) {
			// Sets one point from training data as input
			neuron.setInput(trainset[i]);
			// Trains the perceptron with that one point over num_of_epochs
			neuron.train(trainset[i], trainlabels, iterations, learningr, i);
		}

		// Epoch #3, iterates over all points in training set
		for (int i=0; i<trainset.length; i++) {
			// Sets one point from training data as input
			neuron.setInput(trainset[i]);
			// Trains the perceptron with that one point over num_of_epochs
			neuron.train(trainset[i], trainlabels, iterations, learningr, i);
		}

		// Printing out final weights
		System.out.println("weights final");
		for (double weight : neuron.getWeights()) {
			System.out.println(weight);
		}

		// Printing predictions on testing set
		System.out.println();
		System.out.println("results: ");

		for (double[] set : testset) {
			neuron.setInput(set);
			System.out.println(neuron.getPrediction());
		}

	} // End main

} // End class