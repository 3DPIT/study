using System;

namespace PasswordCheckProgram.checkTools
{
    public class IsNumberCount
    {
        private readonly string _word;
        public IsNumberCount(string word)
        {
            _word = word;
        }
        public int Check()
        {
            //8자리 이상
            if (_word.Length < 8)
            {
                Console.WriteLine("8자리 이상 입력해주세요.");
                return 1;
            }

            return 0;
        }
    }
}