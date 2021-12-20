using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mssqlTest
{
    public class DailyPeopleDbQuery
    {
        public DailyPeopleDbQuery()
        {

        }
        public void Read()
        {
            string connectionString = "server = localhost,1; uid = sa ; pwd = MsSql@Passw0rd; database = master;";
            var sqlConn = new SqlConnection(connectionString);

            SqlCommand sqlComm = new SqlCommand();
            sqlComm.Connection = sqlConn;
            sqlComm.CommandText = @"SELECT * FROM TB_USER;";
            sqlConn.Open();
            using (SqlDataReader SqlRs = sqlComm.ExecuteReader())
            {
                while (SqlRs.Read())
                {
                    Console.WriteLine($"{SqlRs[0].ToString()} {SqlRs[1].ToString()} {SqlRs[2].ToString()}");
                }
            }
            sqlConn.Close();
        }
    }
}
