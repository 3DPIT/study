using System;

namespace PasswordCheckProgram.checkTools
{
    public class PasswordCondition
    {
        private readonly string _word;
        private readonly int _flagCount;
        public PasswordCondition(string word)
        {

            IsHangle isHangle = new IsHangle(word);
            
            IsNumberCount isNumberCount = new IsNumberCount(word);
            
            IsNull isNull = new IsNull(word);
            
            IsSpecialWord isSpecialWord = new IsSpecialWord(word);
            
            IsAlphabet isAlphabet = new IsAlphabet(word);

            _flagCount = isHangle.Check() + isNumberCount.Check() + isNull.Check() + isSpecialWord.Check()+isAlphabet.Check();
            _word = word;
        }

        public void Check()
        {

            if (_flagCount == 0)
            {
                Console.WriteLine($"{_word}은 올바른 비밀번호 입니다.");
            }
            else
            {
                Console.WriteLine($"{_word}은 올바른 비밀번호가 아닙니다.");
            }
        }
    }
}