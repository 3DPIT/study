using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.checkTools
{
    public class IsSpecialWord
    {
        private readonly string _word;
        public IsSpecialWord(string word)
        {
            _word = word;
        }

        public int Check()
        {
            Regex regex = new Regex(@"[`~!@#$%^&*()_+=<>?]");

            if (!regex.IsMatch(_word))
            {
                Console.WriteLine("특수문자를 한글자 이상 포함해주세요.");
                return 1;
            }
            return 0;
        }
    }
}