package lotto.domain;

import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getNumberOfLottos() {
		return lottos.size();
	}

	public void addLottos(Lottos otherLottos) {
		lottos.addAll(otherLottos.getLottos());
	}
}