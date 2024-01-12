package org.example.apibookingmovie.service;

import org.example.apibookingmovie.model.Seat;
import org.example.apibookingmovie.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Long id, Seat seat) {
        if (seatRepository.existsById(id)) {
            seat.setSeatId(id);
            return seatRepository.save(seat);
        }
        return null;
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    public List<Seat> getSeatsByRoomId(Long roomId) {
        // Lấy danh sách tất cả ghế
        List<Seat> allSeats = seatRepository.findAll();

        // Lọc danh sách ghế theo roomId
        List<Seat> seatsInRoom = allSeats.stream()
                .filter(seat -> seat.getRoom().getRoomId().equals(roomId))
                .collect(Collectors.toList());

        return seatsInRoom;
    }

    public Seat bookSeat(Long seatId) {
        // Kiểm tra xem ghế có tồn tại không
        Seat seat = seatRepository.findById(seatId).orElse(null);

        // Nếu ghế tồn tại và chưa được đặt, thực hiện đặt ghế
        if (seat != null && !seat.isBooked()) {
            seat.setBooked(true);
            // Thêm giá cho ghế (Giả sử giá là 10.0, bạn có thể đặt giá từ nguồn dữ liệu khác)
            seat.setSeatPrice(10.0);
            return seatRepository.save(seat);
        }

        return null; // Hoặc có thể ném một exception tùy thuộc vào logic ứng dụng của bạn
    }

}
