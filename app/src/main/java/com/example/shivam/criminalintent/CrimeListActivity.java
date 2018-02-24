package com.example.shivam.criminalintent;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.shivam.criminalintent.SingleFragmentActivity;

/**
 * Created by shivam on 27-12-2017.
 */

public class CrimeListActivity extends SingleFragmentActivity implements  CrimeListFragment.Callbacks,CrimeFragment.Callbacks{
    @Override
    protected Fragment createFragment(){
        return new com.example.shivam.criminalintent.CrimeListFragment();
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }
    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
