using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.checkTools
{
    public class IsHangle
    {
        private readonly string _word;
        public IsHangle(string word)
        {
            _word = word;
        }

        public int Check()
        {
            Regex regex = new Regex(@"[ㄱ-ㅎㅏ-ㅣ가-힣]");

            if (regex.IsMatch(_word))
            {
                Console.WriteLine("한글은 비번으로 설정할 수 없습니다.영문만 입력해주세요.");
                return 1;
            }

            return 0;
        }
    }
}