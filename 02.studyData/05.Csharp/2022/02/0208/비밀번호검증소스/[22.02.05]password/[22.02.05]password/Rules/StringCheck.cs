namespace _22._02._05_password.Rules
{

    public class StringCheck : Rule
    {
        public bool Check(string password) // 조건 0 : 한글 포함 여부 확인 정규식
        {
            string str = @"[ㄱ-ㅎㅏ-ㅣ가-힣]";
            System.Text.RegularExpressions.Regex rex = new System.Text.RegularExpressions.Regex(str);

            return !rex.IsMatch(password);
        }
    }
}