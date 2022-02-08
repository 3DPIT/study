using System;

namespace PasswordCheckProgram.checkTools
{
    public class IsNull
    {
        private readonly string _word;
        public IsNull(string word)
        {
            _word = word;
        }

        public int Check()
        {
            foreach (var word in _word)
            {
                if (word == ' ')
                {
                    Console.WriteLine("공백을 허용하지 않습니다.");
                    return 1;
                }
            }
            return 0;
        }
    }
}