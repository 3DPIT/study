namespace _22._02._05_password.Rules
{

    public class LowerCheck : Rule
    {
        public override bool Check(string password) // 조건 4 : 영문 소문자만 포함 되어 있는 경우
        {
            string lower = @"[a-z]";
            System.Text.RegularExpressions.Regex rex = new System.Text.RegularExpressions.Regex(lower);

            return rex.IsMatch(password);
        }
    }
}