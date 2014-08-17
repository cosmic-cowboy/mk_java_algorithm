package com.slgerkamp.mkjavaalgorithm.stringSearching;

public class StringSearching {

	/**
	 * 単純法<br/>
	 * 探索対象文字列に探索文字列があるかを確認する<br/>
	 * あれば、文字列のインデックスを返す<br/>
	 * なければ、-1<br/>
	 * 
	 * 探索対象文字列に対して、探索文字列をひとつずつ確認する<br/>
	 * 
	 * @param text:探索対象文字列
	 * @param pattern:探索文字列
	 * @return
	 */
	public static int bruteForceMethod(String text, String pattern){
		
		// 探索対象文字列の現在の探索インデックスを表す
		int textIndex = 0;
		// 探索対象文字列に対して探索文字列のインデックスを表す
		int patternIndex = 0;
		
		while(textIndex < text.length() && patternIndex < pattern.length() ){
			
			if(text.charAt(textIndex) == pattern.charAt(patternIndex)){
				textIndex++;
				patternIndex++;
			} else {
				// 探索対象文字列に対して、探索文字列のインデックスが2,3の場合、
				// 新たに探索文字列を探索するため、探索対象の文字列のインデックスを戻す
				textIndex = textIndex - patternIndex + 1;
				patternIndex = 0;
			}
		}
		// 探索が成功した場合、
		// 探索が成功した文字列の先頭インデックスを返す
		if(patternIndex == pattern.length()){ 
			return textIndex - patternIndex;
		}
		// 探索が失敗した場合、-1を返す
		return -1;
	}
}
