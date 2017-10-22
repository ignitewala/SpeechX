package com.speech;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class HelloSpeech {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		// configuration.setGrammarPath("resource:/edu/cmu/sphinx/demo/dialog/");
		// configuration.setUseGrammar(true);

		// configuration.setGrammarName("dialog");

		LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);
		System.out.println("start speaking now:");
		while (true) {
			String utterance = recognizer.getResult().getHypothesis();
			if (utterance.endsWith("stop")) {
				break;
			}

			System.out.println("/>" + utterance);
		}
		
		recognizer.stopRecognition();
	}

}
