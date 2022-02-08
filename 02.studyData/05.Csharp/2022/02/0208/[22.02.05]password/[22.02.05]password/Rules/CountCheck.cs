namespace _22._02._05_password.Rules
{
    public class CountCheck : Rule
    {
        public override bool Check(string password) // 조건 4 : 영문 대문자만 포함 되어 있는 경우
        {
            if (password.Length < 8)
            {
                return false;
            }

            return true;
        }
    }
}