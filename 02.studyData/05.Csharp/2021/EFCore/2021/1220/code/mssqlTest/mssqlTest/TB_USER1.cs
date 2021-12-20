using System.ComponentModel.DataAnnotations;

namespace mssqlTest
{
    public class TB_USER1
    {
        [Key]
        public string USER_NO { get; set; }
        public string USER_NAME { get; set; }
        public string START_TIME { get; set; }
    }
}