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
		return index(pattern, textIndex, patternIndex);
	}

	
	/**
	 * KMP法<br/>
	 * 探索対象文字列に探索文字列があるかを確認する<br/>
	 * あれば、文字列のインデックスを返す<br/>
	 * なければ、-1<br/>
	 * 
	 * 探索文字列の文字の重なりをテーブルに格納（skipテーブル）<br/>
	 * skipテーブルを利用して探索数の効率化を図っている<br/>
	 * 
	 * @param text:探索対象文字列
	 * @param pattern:探索文字列
	 * @return
	 */
	public static int knuthMorrisPrattMethod(String text, String pattern){
		
		// スキップテーブルの作成
		int[] skipTable = createSkipTable(pattern);
		
		// 探索対象文字列の現在の探索インデックスを表す
		int textIndex = 0;
		// 探索対象文字列に対して探索文字列のインデックスを表す
		int patternIndex = 0;

		// 文字列探索
		while(textIndex < text.length() && patternIndex < pattern.length()){
			if(text.charAt(textIndex) == pattern.charAt(patternIndex)){
				//  単純法と同じ
				textIndex++;
				patternIndex++;
			} else if (patternIndex == 0){
				//  単純法と実質同じ
				textIndex++;
			} else {
				// 単純法と異なる部分
				// 探索文字列のどこまで一致したかによって
				// 探索文字列のどの文字から探索するかをskiskipPatternAxisableを利用して設定
				patternIndex = skipTable[patternIndex];
			}
		}
		
		return index(pattern, textIndex, patternIndex);
	}

	
	/**
	 * boyer Moore法<br/>
	 * 探索対象文字列に探索文字列があるかを確認する<br/>
	 * あれば、文字列のインデックスを返す<br/>
	 * なければ、-1<br/>
	 * 
	 * パターンの末尾から先頭に探索を行う<br/>
	 * 
	 * @param text:探索対象文字列
	 * @param pattern:探索文字列
	 * @return
	 */
	public static int boyerMooreMethod(String text, String pattern){
		
		// 探索対象文字列の現在の探索インデックスを表す
		int textIndex = pattern.length() - 1;
		// 探索対象文字列に対して探索文字列のインデックスを表す
		int patternIndex = pattern.length() - 1;

		// 文字列探索
		while(textIndex < text.length() && patternIndex < pattern.length() && patternIndex > -1){
			if(text.charAt(textIndex) == pattern.charAt(patternIndex)){
				textIndex--;
				patternIndex--;
				System.out.println("text.charAt(textIndex) == pattern.charAt(patternIndex)" + ", textIndex:" + textIndex + ", patternIndex:" + patternIndex);
			} else if (patternIndex == 0){
				textIndex += pattern.length();
				patternIndex += pattern.length() - 1;
				System.out.println("else if (patternIndex == 0)" + ", textIndex:" + textIndex + ", patternIndex:" + patternIndex);
			} else {
				patternIndex--;
				System.out.println("else" + ", textIndex:" + textIndex + ", patternIndex:" + patternIndex);
			}
		}
		// 探索が成功した場合、
		// 探索が成功した文字列の先頭インデックスを返す
		if(patternIndex < 0){ 
			return ++textIndex;
		}
		// 探索が失敗した場合、-1を返す
		return -1;
	}

	
	//////////////////////////////////////////
	/// プライベートメソッド(private method)  ///
	//////////////////////////////////////////

	/**
	 * 探索文字列のスキップテーブルを作成する<br/>
	 * 
	 * @param pattern:探索文字列
	 * @return
	 */
	private static int[] createSkipTable(String pattern) {
		// スキップテーブルの作成
		int [] skipTable = new int [pattern.length() + 1];
		// スキップするかの基準となる値
		int skipPatternAxis = 0;
		// インデックスをいくつスキップするかの対象
		int skipPatternTarget = 1;

		System.out.println(pattern);
		
		// 文字の再開位置を設定
		// 探索文字列から重複する文字を洗い出し、
		// 次に検索する探索文字列のインデックスを導く
		while(skipPatternTarget < pattern.length()){
			// インデックスが1以降の文字列の中に
			// 先頭からの文字列を同じがあった場合、
			// 探索対象文字列のインデックスを戻すことなく、探索できるように
			// インデックスの何番目の場合、先頭インデックスからどこまで重なっているかを求める
			if(pattern.charAt(skipPatternTarget) == pattern.charAt(skipPatternAxis)){
				skipTable[++skipPatternTarget] = ++skipPatternAxis;
				System.out.println("pattern.charAt(skipPatternTarget) == pattern.charAt(skipPatternAxis)" + ", skipPatternTarget:" + skipPatternTarget + ", skipPatternAxis:" + skipPatternAxis);
			} else if(skipPatternAxis == 0){
				// 先頭の文字列と重なる部分がないので、次の文字列と探索する際はインデックス0から始まる
				skipTable[++skipPatternTarget] = skipPatternAxis;
				System.out.println("skipPatternAxis == 0" + ", skipPatternTarget:" + skipPatternTarget + ", skipPatternAxis:" + skipPatternAxis);
			} else {
				// 
				skipPatternAxis = skipTable[skipPatternAxis];
				System.out.println("else" + ", skipPatternTarget:" + skipPatternTarget + ", skipPatternAxis:" + skipPatternAxis);
			}
		}
		for(int i : skipTable){
			System.out.print(i);			
		}
		System.out.println();
		return skipTable;
	}
	
	
	/**
	 * 探索対象文字列の返却用インデックスを算出
	 * 
	 * @param pattern:探索文字列
	 * @param textIndex:探索対象文字列の現在の探索インデックス
	 * @param patternIndex:探索対象文字列に対して探索文字列のインデックスを表す
	 * @return
	 */
	private static int index(String pattern, int textIndex, int patternIndex) {
		// 探索が成功した場合、
		// 探索が成功した文字列の先頭インデックスを返す
		if(patternIndex == pattern.length()){ 
			return textIndex - patternIndex;
		}
		// 探索が失敗した場合、-1を返す
		return -1;
	}

}
