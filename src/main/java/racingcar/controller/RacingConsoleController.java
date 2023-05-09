package racingcar.controller;

import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.repository.MemoryGameHistoryDao;
import racingcar.repository.MemoryGameResultDao;
import racingcar.repository.dao.JdbcGameHistoryDao;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingConsoleController {

    public static void main(String[] args) {
        RacingCarService racingCarService = new RacingCarService(new MemoryGameHistoryDao(), new MemoryGameResultDao(),new JdbcGameHistoryDao());

        RacingCarRequestDto racingCarRequestDto = new RacingCarRequestDto(InputView.getRacingCarNames(), InputView.getNumberOfAttempt());
        RacingCarResponseDto racingCarResponseDto = racingCarService.game(racingCarRequestDto);

        ResultView.printLocationsByCars(racingCarResponseDto);
    }
}