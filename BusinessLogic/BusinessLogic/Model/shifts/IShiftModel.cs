

using BusinessLogic.Model.Shared;
using System.Threading.Tasks;

namespace BusinessLogic.Model.shifts
{
    interface IShiftModel
    {
        Task<string> GetShift(int id);
        Task<string> GetAllShifts(string UserId, string AccessLevel, string date);
        Task<string> PostShift(Shift shift);
        Task<string> UpdateShift(Shift shift);
    }
}
