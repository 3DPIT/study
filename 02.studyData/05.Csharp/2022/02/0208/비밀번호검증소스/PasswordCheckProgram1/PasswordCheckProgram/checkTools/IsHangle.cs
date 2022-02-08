using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.checkTools
{
    public class IsHangle : Rule
    {

        public override bool Check(string password)
        {
            Regex regex = new Regex(@"[ㄱ-ㅎㅏ-ㅣ가-힣]");

            if (regex.IsMatch(password))
            {
                Console.WriteLine("한글은 비번으로 설정할 수 없습니다.영문만 입력해주세요.");
                return true;
            }

            return false;
        }
    }
}