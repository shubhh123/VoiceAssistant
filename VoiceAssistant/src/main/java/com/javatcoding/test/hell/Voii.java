package com.javatcoding.test.hell;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;

import edu.cmu.sphinx.api.SpeechResult;


public class Voii {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src/main/java/7558.dic");
		config.setLanguageModelPath("src/main/java/7558.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);  // LiveSpeechRecognizer uses a microphone as the speech source.
			speech.startRecognition(true);  // Start recognition process pruning previously cached data.
			
			SpeechResult speechResult = null;
			
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
				
				if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");  //Runtime.getRuntime() returns the runtime object associated with the current java application.
				}														   //Runtime.exec(String command) method executes the specified string command in a separate process.
																		   //cmd.exe is a way to start cmd.exe is to press Win+R and then type the three letters cmd, followed by the ENTER key.
				else if (voiceCommand.equalsIgnoreCase("Open Brave")) {
						Runtime.getRuntime().exec("cmd.exe /c start brave www.google.com");
						
				}
				else if (voiceCommand.equalsIgnoreCase("Please open notepad")) {
					Runtime.getRuntime().exec("cmd.exe /c start notepad");
					
				}else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
				else if (voiceCommand.equalsIgnoreCase("Close Brave")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM brave.exe");
			}
				else if (voiceCommand.equalsIgnoreCase("Close Notepad")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM notepad.exe");
			}
		}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}



//DICTIONARY
/*
 * The dictionary is a list of all 
 * in-vocabulary words (both their spelling 
 * and their phonetic pronunciation) that the 
 * system can recognize. Any word or phrase 
 * spoken that's not on this list has no chance 
 * of being recognized, and is considered "out of 
 * voc" (OOV) -- typically these are discounted when 
 * determining the recognition accuracy of a system.
 * A pronunciation dictionary is used to find the relevant sequences of phones,*/
 

//ACOUSTIC MODEL
/*
 * The acoustic model represents characteristics 
 * of the potential speaker so the system can 
 * recognize phonemes.
 * The pre-made acoustic models include American English and French in full bandwidth*/



//LANGUAGE MODEL
/*
 * The language model provides context to distinguish between 
 * words and phrases that sound phonetically similar. 
 * For example, in American English, the phrases "recognize speech"
 * and "wreck a nice beach" sound similar, but mean different things.
 * Assigns probability values to sequence of words.
 * it helps us predict the next words in a sentence
 * 
 * One solution is to make the assumption that the probability of a word 
 * only depends on the previous n words. This is known as an n-gram model or
 *  unigram model when n = 1.*/


