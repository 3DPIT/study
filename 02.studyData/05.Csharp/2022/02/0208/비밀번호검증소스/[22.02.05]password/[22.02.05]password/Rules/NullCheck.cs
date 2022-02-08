namespace _22._02._05_password.Rules
{
    public class NullCheck : Rule
    {
        public override bool Check(string password) // 조건 4 : 영문 대문자만 포함 되어 있는 경우
        {
            if(password.Contains(" ") == true)
            {
                return false;
            }

            return true;
        }
    }
}