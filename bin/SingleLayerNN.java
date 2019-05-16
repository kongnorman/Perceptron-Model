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

		double learningr = 15;
		int its = 10000;

		// Create perceptron object
		Perceptron neuron = new Perceptron(trainset[0]);

		//System.out.println("weights initial");
		//for (double weight : neuron.getWeights()) {
		//	System.out.println(weight);
		//}

		// Training
		for (int i=0; i<trainset.length; i++) {
			neuron.setInput(trainset[i]);
			neuron.train(trainset[i], trainlabels, its, learningr, i);
		}

		//System.out.println("weights final");
		//for (double weight : neuron.getWeights()) {
		//	System.out.println(weight);
		//}

		// Test results
		System.out.println();
		System.out.println("results: ");

		for (double[] set : testset) {
			neuron.setInput(set);
			System.out.println(neuron.sig(neuron.z(neuron.getWeights(), neuron.getInput())));
			if (neuron.sig(neuron.z(neuron.getWeights(), neuron.getInput())) < 0.5)
				System.out.println("prediction:  0");
			else
				System.out.println("prediction: 1");
		}

	} // End main

} // End class