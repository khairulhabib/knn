package com.iancaffey.knn;

import com.iancaffey.knn.feature.Feature;
import com.iancaffey.knn.feature.FeatureSet;
import com.iancaffey.knn.util.Features;

import java.util.Arrays;

/**
 * StaticClassifier
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StaticClassifier implements Classifier {
    @Override
    public Classification classify(FeatureSet set, int k, Feature<?>... features) {
        if (set == null || k < 0 || features == null || features.length == 0)
            throw new IllegalArgumentException();
        if (k == 0)
            return Classification.NONE;
        Arrays.sort(features, (o1, o2) -> Features.compare(set, o1, o2));
        return new Classification(features[0], Arrays.copyOf(features, k));
    }
}
