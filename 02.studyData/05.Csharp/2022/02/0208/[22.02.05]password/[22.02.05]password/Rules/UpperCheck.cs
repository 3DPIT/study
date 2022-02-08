namespace _22._02._05_password.Rules
{
    public class UpperCheck : Rule
    {
        public override bool Check(string password) // 조건 4 : 영문 대문자만 포함 되어 있는 경우
        {
            string upper = @"[A-Z]";
            System.Text.RegularExpressions.Regex rex = new System.Text.RegularExpressions.Regex(upper);

            return rex.IsMatch(password);
        }
    }
}