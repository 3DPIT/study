namespace _22._02._05_password.Rules
{
    public class StarCheck : Rule
    {
        public bool Check(string password) // 조건 3 : 특수문자 포함 여부 확인 정규식
        {
            string star = @"[~!@\#$%^&*\()\=+|\\/:;?""<>']";
            System.Text.RegularExpressions.Regex rex = new System.Text.RegularExpressions.Regex(star);

            return rex.IsMatch(password);
        }
    }
}